/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.rest;

import bisaggio.nasa.NasaApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author bisaggio
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NasaApplication.class)
@WebAppConfiguration
public class RobbotResourceTest {

    private MockMvc mockContext;
    private static final String URI = "/rest/mars/";

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockContext = webAppContextSetup(context).build();
    }

    @Test
    public void MustGoSouth2SouthFacing() throws Exception {
        mockContext.perform(post(URI + "MMRMMRMM")).andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void MustGoWest2WestFacing() throws Exception {
        mockContext.perform(post(URI + "MML")).andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void MustGoWest2WestFacingWhestRepeatedMovement() throws Exception {
        mockContext.perform(post(URI + "MML")).andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
        
        mockContext.perform(post(URI + "MML")).andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void shouldReturnInvalidMovement() throws Exception {
        mockContext.perform(post(URI + "AAA"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnMovementOffTheGround() throws Exception {
        mockContext.perform(post(URI + "MMMMMMMMMMMMMMMMMMMMMMMM"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnIsNotFound() throws Exception {
        mockContext.perform(post("api"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnTerrainBoundaryFacingEast() throws Exception {
        mockContext.perform(post(URI + "MMMMMRMMMMM"))
                .andExpect(status().isOk()).andExpect(content().string("(5, 5, E)"));
    }

}
