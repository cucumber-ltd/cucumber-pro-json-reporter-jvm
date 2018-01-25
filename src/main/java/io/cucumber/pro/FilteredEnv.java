package io.cucumber.pro;

import io.cucumber.pro.config.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class FilteredEnv {
    private final Pattern maskPattern;
    private final Map<String, String> env;

    FilteredEnv(Map<String, String> env, Config config) {
        String mask = config.getString(Keys.CUCUMBERPRO_ENVMASK);
        this.maskPattern = Pattern.compile(String.format(".*(%s).*", mask), Pattern.CASE_INSENSITIVE);
        this.env = env;
    }

    private Map<String, String> clean() {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : this.env.entrySet()) {
            if (!maskPattern.matcher(entry.getKey()).matches())
                result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public String toString() {
        StringBuilder envb = new StringBuilder();

        Map<String, String> clean = clean();
        List<String> sortedKeys = new ArrayList<>(clean.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            envb.append(key).append("=").append(clean.get(key)).append("\n");
        }
        return envb.toString();
    }
}
