/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insat.gl5.crm_pfa.service;

import com.insat.gl5.crm_pfa.model.ActivationCode;
import com.insat.gl5.crm_pfa.model.Contact;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mu7ammed 3li -- mohamed.ali.affes@gmail.com --
 */

public class ContactService extends GenericService{

    private static final String SUCCESS = " with success";
    
    /**
     * Save new Contact
     *
     * @param contact 
     */
    public void saveContact(Contact contact) throws Exception {

        try {
            persist(contact);
            log.info("Create Contact " + getDisplayText(contact) + SUCCESS);
        } catch (Exception ex) {
            log.error("Error in Creating Contact "+getDisplayText(contact)+ " : -->", ex);
            throw ex;
        }
    }

    /**
     * Delete a Contact
     *
     * @param contact 
     */
    public void deleteContact(Contact contact) throws Exception {
        try {
            delete(contact);
            log.info("Delete Contact " + getDisplayText(contact)+ SUCCESS);
        } catch (Exception ex) {
            log.error("Error in Deleting Contact "+getDisplayText(contact)+" : -->", ex);
            throw ex;
        }
    }

    /**
     * Edit a Contact
     *
     * @param contact 
     */
    public void editContact(Contact contact) throws Exception {

        try {
            edit(contact);
            log.info("Update Contact " + getDisplayText(contact) + SUCCESS);
        } catch (Exception ex) {
            log.error("Error in Updating Contact "+getDisplayText(contact)+" : -->", ex);
            throw ex;
        }
    }

     /**
     * Get a list of all contacts figured in database
     *
     * @return 
     */
    public List<Contact> getAllContacts() {
        TypedQuery query = em.createQuery("SELECT c FROM Contact c", Contact.class);
        return query.getResultList();
    }
    
    private String getDisplayText(Contact contact){
        return contact.getFirstName()+ " "+contact.getLastName();
    }
    
      /**
     * Save new ActivationCode
     *
     * @param activationCode  
     */
    public void saveActivationCode(ActivationCode activationCode) throws Exception {

        try {
            persist(activationCode);
            log.info("Create ActivationCode " + activationCode + SUCCESS);
        } catch (Exception ex) {
            log.error("Error in Creating ActivationCode "+activationCode+ " : -->", ex);
            throw ex;
        }
    }

    /**
     * Delete an ActivationCode
     *
     * @param activationCode 
     */
    public void deleteActivationCode(ActivationCode activationCode) throws Exception {
        try {
            delete(activationCode);
            log.info("Delete ActivationCode " + activationCode+ SUCCESS);
        } catch (Exception ex) {
            log.error("Error in Deleting ActivationCode "+activationCode+" : -->", ex);
            throw ex;
        }
    }
    public ActivationCode getActivationCode(String code) throws NoResultException{
       Query query = em.createQuery("select a from ActivationCode a where a.code =?1");
       query.setParameter(1, code);
       return (ActivationCode) query.getSingleResult();
    }
}
