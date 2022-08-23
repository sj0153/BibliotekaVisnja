/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;

/**
 *
 * @author Stefan
 * @param <C>
 */
public interface Repository<C>{
    List<C> vratiSve() throws Exception;
    C vrati(C param) throws Exception;
    void kreiraj(C param) throws Exception;
    void azuriraj(C param) throws Exception;
    void obrisi(C param) throws Exception;
    void connect() throws Exception;
    void disconnect() throws Exception;
    void commit() throws Exception;
    void rollback() throws Exception; 
}
