package com.jsystems.testautomation;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    public static final Config CONFIG = ConfigFactory.load("config.conf");
    public static final String ENVIRONMENT = CONFIG.getString("environment");
    public static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String WORDPRESS_EMAIL =ENV.getString("login");
    public static final String WORDPRESS_PASSWD =ENV.getString("password");
    public static final String WORDPRESS_URL=ENV.getString("baseUrlWordPress");

}
