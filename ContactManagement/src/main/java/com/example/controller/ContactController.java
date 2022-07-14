package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Contact;
import com.example.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
		Contact c = null;
		try {
			c = this.contactService.addContact(contact);
			System.out.println(contact);
			return ResponseEntity.of(Optional.of(c));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/getcontact", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> getContact() {

		List<Contact> list = contactService.getAllContact();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@RequestMapping(value = "/contact/{contactId}", method = RequestMethod.PUT)
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact,
			@PathVariable("contactId") int contactId) {
		try {
			this.contactService.updateContact(contact, contactId);
			return ResponseEntity.ok().body(contact);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/contact/{contactId}", method = RequestMethod.DELETE)
	public ResponseEntity<Contact> deleteContact(@PathVariable("contactId") int contactId) {
		try {
			this.contactService.deleteContact(contactId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
