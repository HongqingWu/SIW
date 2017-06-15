package it.uniroma3.siw.galleria.service;
@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {
	public EmailExistsException(final String message) {
        super(message);
    }

}
