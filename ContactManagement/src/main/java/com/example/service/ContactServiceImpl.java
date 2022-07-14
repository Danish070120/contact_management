package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomException;
import com.example.entity.Contact;
import com.example.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public List<Contact> fetchContactList() {
		try {
			return (List<Contact>) contactRepository.findAll();

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

	@Override
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public Contact addContact(Contact contact) {
		try {

			log.info("contact {}", contact);
			contact.getCntEmail().stream().forEach(cntEmail -> cntEmail.setContact(contact));
			contact.getCntAddress().stream().forEach(cntAddress -> cntAddress.setContact(contact));
			contact.getCntPhone().stream().forEach(cntPhone -> cntPhone.setContact(contact));
			contact.getCntSocial().stream().forEach(cntSocial -> cntSocial.setContact(contact));
			contactRepository.save(contact);
			return contact;

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());
		}
	}

	@Override
	public List<Contact> getAllContact() {
		try {
			return contactRepository.findAll();

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

	@Override
	public void updateContact(Contact contact, int contactId) {

		try {

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

	@Override
	public void deleteContact(int contactId) {

		try {

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

}
