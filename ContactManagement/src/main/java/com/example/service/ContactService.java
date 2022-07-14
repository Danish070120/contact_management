package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Contact;

public interface ContactService {

	//Contact saveContact(Contact contact);

	List<Contact> fetchContactList();

	Optional<Contact> findById(int id);

	Contact addContact(Contact contact);

	List<Contact> getAllContact();

	void updateContact(Contact contact, int contactId);

	void deleteContact(int contactId);

	

}
