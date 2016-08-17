/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.kasse.engine.test.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import dev.kasse.engine.repository.query.TicketRepository;
import dev.kasse.engine.service.TicketService;
import dev.kasse.engine.test.AbstractTest.AbstractTest;
import dev.kasse.engine.test.MockProvider.TicketMockProvider;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repository-context.xml")
@WebAppConfiguration
public class TicketControllerTest extends AbstractTest {

  public static final String PATH = "/ticket";

  public static final String ALL = PATH + "/all";

  public static final String ID = PATH + "/id";

  public static final String STATE = PATH + "/state";

  public static final String PAYMENT_TYPE = PATH + "/paymentType";

  public static final String TABLE_NUMBER = PATH + "/tableNumber";

  @Autowired
  private WebApplicationContext ctx;

  private MockMvc mockMvc;

  @Autowired
  @InjectMocks
  private TicketService ticketService;

  @Mock
  private TicketRepository ticketRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    ticketService.setTicketRepository(ticketRepository);
  }

  @Test
  public void getAllTickets() throws Exception {

    Mockito.when(ticketRepository.findAll()).thenReturn(
        TicketMockProvider.createTickets());

    this.mockMvc.perform(get(ALL)).andExpect(status().isOk())
        .andExpect(jsonPath("$.*", hasSize(1)))
        .andExpect(jsonPath("$[0].ticketItems", hasSize(2)));
  }

  @Test
  public void getByMissingIdParameter() throws Exception {

    Mockito.when(ticketRepository.findById("kasseId")).thenReturn(
        TicketMockProvider.createNewTicket(1));

    this.mockMvc.perform(get("/ticket/id")).andExpect(status().isOk())
        .andExpect(jsonPath("id").value("kasseId"));

  }

  @Test
  public void getById() throws Exception {

    Mockito.when(ticketRepository.findById("kasseId")).thenReturn(
        TicketMockProvider.createNewTicket(1));

    this.mockMvc.perform(get("/ticket/id").param("id", "kasseId"))
        .andExpect(status().isOk()).andExpect(jsonPath("id").value("kasseId"));

  }

}
