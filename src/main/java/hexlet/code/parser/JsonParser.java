package hexlet.code.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static java.nio.file.Files.readString;

public final class JsonParser implements Parser {
    @Override
    public Map<String, Object> parse(String path) throws IOException {
        Path absolutePath = Utils.getAbsolutePath(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(readString(absolutePath), new TypeReference<>() {
        });
    }
}
