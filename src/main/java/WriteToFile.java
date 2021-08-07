import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WriteToFile {

    public void writeToFile(Path path, Object object) throws IOException {

        Field[] fields = object.getClass().getDeclaredFields();

        List<String> fieldsNames = Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.toList());

        List<String> fieldValues = Arrays.stream(fields)
                .map(field -> {
                    try {
                        field.setAccessible(true);

                        TextFormat textFormat = field.getAnnotation(TextFormat.class);
                        if (textFormat != null) {
                            if (textFormat.format() == TextFormatEnum.UPPERCASE) {
                                return field.get(object).toString().toUpperCase();
                            } else if (textFormat.format() == TextFormatEnum.LOWERCASE) {
                                return field.get(object).toString().toLowerCase();
                            } else if (textFormat.format() == TextFormatEnum.FIRST_CHAR_UPPER) {
                                String text = field.get(object).toString();
                                return text.substring(0, 1).toUpperCase() + text.substring(1);
                            }
                        }
                        DateFormat dateFormat = field.getAnnotation(DateFormat.class);
                        if (dateFormat != null) {
                            if (dateFormat.format() == DateFormatEnum.dd_MM_yyyy) {
                                String pattern = "dd-MM-yyyy";
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
                                LocalDate date = LocalDate.parse(field.get(object).toString());
                                return date.format(dateTimeFormatter);
                            }else if (dateFormat.format() == DateFormatEnum.d_MMMM_yyyy) {
                                String pattern = "d.MMMM yyyy";
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
                                LocalDate date = LocalDate.parse(field.get(object).toString());
                                return date.format(dateTimeFormatter);
                            }

                        }
                        NumberFormat numberFormat = field.getAnnotation(NumberFormat.class);
                        if (numberFormat != null) {
                            if (numberFormat.format() == NumberFormatEnum.DOT_ZERO) {
                                return String.format("%.0f", field.get(object)).replace(",",".");
                            } else if (numberFormat.format() == NumberFormatEnum.DOT_ONE) {
                                return String.format("%.1f", field.get(object)).replace(",",".");
                            } else if (numberFormat.format() == NumberFormatEnum.DOT_TWO) {
                                return String.format("%.2f", field.get(object)).replace(",",".");
                            }
                        }
                        return field.get(object).toString();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e){
                        return null;
                    }
                    return "";
                }).collect(Collectors.toList());

        Files.write(path, List.of(String.join(",", fieldsNames), String.join(",", fieldValues)), StandardCharsets.UTF_8);
    }
}
