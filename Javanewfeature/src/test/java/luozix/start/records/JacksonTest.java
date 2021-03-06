    /**
	 * Project Name:java11_in_action
	 * File Name:JacksonTest.java
	 * Package Name:luozix.start.java14.records
	 * Date:2021年3月6日上午12:09:38
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
	 * 
	*/
	/**
* @Title: JacksonTest.java
* @Package luozix.start.java14.records
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com
* @date 2021年3月6日 上午12:09:38
* @version V1.0
*/
	  
	package luozix.start.records;
	/**
	 * ClassName:JacksonTest <br/>
	 * Function: TODO ADD FUNCTION. <br/>
	 * Reason:   TODO ADD REASON. <br/>
	 * Date:     2021年3月6日 上午12:09:38 <br/>
	 * @author   xiaoy
	 * @version
	 * @since    JDK 1.8
	 * @see
	 */


import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

/**
* @ClassName: JacksonTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月6日 上午12:09:38
* @version
*@since JDK 1.8
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

class JacksonTest implements WithAssertions {

    record Person(
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName,
            String address,
            Date birthday,
            List<String> achievements
    ) {
    }

    static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    @Test
    void serializeRecord() throws Exception {
        // Given
        var person = new Person(
                "John",
                "Doe",
                "USA",
                new Date(981291289182L),
                List.of("Speaker")
        );

        var json = """
                {
                  "first_name" : "John",
                  "last_name" : "Doe",
                  "address" : "USA",
                  "birthday" : 981291289182,
                  "achievements" : [ "Speaker" ]
                }""";

        // When
        var serialized = mapper.writeValueAsString(person);

        // Then
        assertThat(serialized).isEqualTo(json);
    }

    @Test
    void deserializeRecord() throws Exception {
        // Given
        var person = new Person(
                "John",
                "Doe",
                "USA",
                new Date(981291289182L),
                List.of("Speaker")
        );

        var json = """
                {
                  "first_name" : "John",
                  "last_name" : "Doe",
                  "address" : "USA",
                  "birthday" : 981291289182,
                  "achievements" : [ "Speaker" ]
                }""";

        // When
        var deserialized = mapper.readValue(json, Person.class);

        // Then
        assertThat(deserialized).isEqualTo(person);
    }
}