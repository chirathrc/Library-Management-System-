package libraryManagementSystem.service.serviceInterfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.ReturnBookEntity;

public interface BookReturnServiceInterface {


    public List<ReturnBookEntity> ReturnBooks(String NIC) throws Exception;

    public boolean ReturnBookFinal(ReturnBookEntity bookEntity, String NIC) throws Exception;

}
