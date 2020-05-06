package com.gml.cursomc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public abstract class GenericTest {
    protected MockMvc mockMvc;

    protected Mockito mockito;

    protected MockMvcBuilders builders;

    protected MockHttpServletResponse response;

    @Before
    public void before() {

    }

    public MockHttpServletResponse perform(RequestBuilder requestBuilder) throws Exception {
        return mockMvc.perform(
                requestBuilder
        ).andReturn().getResponse();
    }

    public MockHttpServletRequestBuilder get(String url) {
        return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(url)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
    }

    public MockHttpServletRequestBuilder post(String url) {
        return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void standaloneSetup(Object ... objects) {
        mockMvc = MockMvcBuilders.standaloneSetup(objects).build();
    }

    public void assertNotNull(Object object) {
        org.junit.Assert.assertNotNull(object);
    }

    public void assertEquals(Object object, Object other) {
        junit.framework.TestCase.assertEquals(object, other);
    }

    public int ok() {
        return HttpStatus.OK.value();
    }
    public int created() {
        return HttpStatus.CREATED.value();
    }

}
