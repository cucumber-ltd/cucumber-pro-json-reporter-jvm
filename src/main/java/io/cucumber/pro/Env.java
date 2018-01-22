package io.cucumber.pro;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class Env {
    public static final String bamboo_planRepository_revision = "bamboo_planRepository_revision";
    public static final String CUCUMBER_PRO_TOKEN = "CUCUMBER_PRO_TOKEN";
    public static final String CUCUMBER_PRO_BASE_URL = "CUCUMBER_PRO_BASE_URL";
    public static final String CUCUMBER_PRO_GIT_HOST = "CUCUMBER_PRO_GIT_HOST";
    public static final String CUCUMBER_PRO_GIT_SSH_PORT = "CUCUMBER_PRO_GIT_SSH_PORT";
    public static final String CUCUMBER_PRO_GIT_HOST_KEY = "CUCUMBER_PRO_GIT_HOST_KEY";
    public static final String CUCUMBER_PRO_GIT_DEBUG = "CUCUMBER_PRO_GIT_DEBUG";
    public static final String CUCUMBER_PRO_GIT_PUBLISH = "CUCUMBER_PRO_GIT_PUBLISH";
    public static final String CUCUMBER_PRO_GIT_PUBLISH_KEY = "cucumber.pro.git.publish";
    public static final String CUCUMBER_PRO_PUBLISH = "CUCUMBER_PRO_PUBLISH";
    public static final String CUCUMBER_PRO_PROJECT_NAME = "CUCUMBER_PRO_PROJECT_NAME";
    public static final String CUCUMBER_PRO_IGNORE_CONNECTION_ERROR = "CUCUMBER_PRO_IGNORE_CONNECTION_ERROR";
    public static final String CUCUMBER_PRO_CONNECTION_TIMEOUT_MILLIS = "CUCUMBER_PRO_CONNECTION_TIMEOUT";
    public static final String CUCUMBER_PRO_ENV_MASK = "CUCUMBER_PRO_ENV_MASK";
    public static final String CUCUMBER_PRO_SOURCE_REMOTE_NAME = "CUCUMBER_PRO_SOURCE_REMOTE_NAME";
    public static final String CUCUMBER_PRO_FETCH_FROM_SOURCE = "CUCUMBER_PRO_FETCH_FROM_SOURCE";
    public static final String CUCUMBER_PRO_LOG_LEVEL = "CUCUMBER_PRO_LOG_LEVEL";
    public static final String CIRCLE_SHA1 = "CIRCLE_SHA1";
    public static final String GIT_COMMIT = "GIT_COMMIT";
    public static final String TRAVIS_COMMIT = "TRAVIS_COMMIT";

    private final Map<String, String> env;

    public Env(Map<String, String> env) {
        this.env = env;
    }

    public String get(String key) {
        return env.get(key);
    }

    public String get(String key, String defaultValue) {
        String value = env.get(key);
        if (value != null) return value;
        return defaultValue;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String value = env.get(key);
        if (value != null) {
            return !value.toLowerCase().matches("false|no");
        }
        return defaultValue;
    }

    public int getInt(String key, int defaultValue) {
        String value = env.get(key);
        if (value != null) {
            return parseInt(value.toLowerCase());
        }
        return defaultValue;
    }

    public Map<String, String> all() {
        return env;
    }
}
