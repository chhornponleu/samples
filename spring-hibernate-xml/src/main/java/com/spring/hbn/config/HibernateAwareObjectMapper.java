package com.spring.hbn.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 4152600582756689770L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}
