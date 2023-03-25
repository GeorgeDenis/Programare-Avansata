package org.example.commands;

import org.example.model.Catalog;
import org.example.model.Document;
import org.example.exceptions.InvalidCatalogException;
import org.example.exceptions.InvalidDocumentException;

public class AddCommand implements Command {

    private Catalog catalog;
    private Document document;

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Document getDocument() {
        return document;
    }

    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    /**
     * Metoda adauga un document intr-un catalog
     * @throws InvalidDocumentException
     * @throws InvalidCatalogException
     */
    public void execute() throws InvalidDocumentException, InvalidCatalogException {
        if(catalog == null)
        {
            throw new InvalidCatalogException("Catalogul " + catalog.getName() + " nu exista!");
        }
        else
        if (catalog.findById(document.getId()) != null) {
            throw new InvalidDocumentException("Documentul cu id-ul " + document.getId() + " exista deja!");
        } else {
            catalog.addDoc(document);
        }
    }
}
