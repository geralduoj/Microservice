/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.microservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
