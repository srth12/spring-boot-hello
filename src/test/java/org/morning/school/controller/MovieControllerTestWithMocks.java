package org.morning.school.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.morning.school.model.Movie;
import org.morning.school.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTestWithMocks {

    @Autowired
    public WebApplicationContext wac;

    private MockMvc mvc;

    @MockBean
    MovieRepository repository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getMovie() throws Exception {
        given(repository.getMovie("tt4832640"))
            .willReturn(new Movie("No Idiots,2009/12/25,Amir Khan,Kareena Kapoor,326,Comedy,tt1187043"));

        ResultActions resultActions = mvc.perform(get("/movies/tt4832640").accept(MediaType.TEXT_HTML));

        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No Idiots")));

    }
}