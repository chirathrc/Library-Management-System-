package libraryManagementSystem.service.serviceInterfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;

public interface ReaderCRUDServiceInterfaces {

    public Boolean readerInsert(ReaderInsertDetailsDTO readerInsertDetails) throws Exception;

    public List<ReaderEntity> AllReaders() throws Exception;

    public boolean ReaderUpdate(ReaderInsertDetailsDTO readerDetailsDTO) throws Exception;

    public List<ReaderEntity> SelectReaders(String s) throws Exception;

    public boolean DeleteReader(ReaderInsertDetailsDTO detailsDTO) throws Exception;

}
