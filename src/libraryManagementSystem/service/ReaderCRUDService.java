package libraryManagementSystem.service;

import java.util.List;

import libraryManagementSystem.dao.ReaderDAOImpl;
import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dao.interfaces.ReaderDAOInterface;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;
import libraryManagementSystem.service.serviceInterfaces.ReaderCRUDServiceInterfaces;

public class ReaderCRUDService implements ReaderCRUDServiceInterfaces {

    ReaderDAOInterface readerDAOImpl;

    public ReaderCRUDService() throws Exception {

        readerDAOImpl = new ReaderDAOImpl();

    }

    @Override
    public Boolean readerInsert(ReaderInsertDetailsDTO readerInsertDetails) throws Exception {

        // System.out.println("DTO : "+readerInsertDetails);

        return readerDAOImpl.InsertReader(
                new ReaderEntity(null, readerInsertDetails.getReaderFname(), readerInsertDetails.getReaderLname(),
                        readerInsertDetails.getReaderNic(), readerInsertDetails.getReaderBirthday(),
                        readerInsertDetails.getReaderGender(), readerInsertDetails.getReaderRegisterTime(), 1));

    }

    @Override
    public List<ReaderEntity> AllReaders() throws Exception {

        return readerDAOImpl.LoadAllReaders();
    }

    @Override
    public boolean ReaderUpdate(ReaderInsertDetailsDTO readerDetailsDTO) throws Exception {

        return readerDAOImpl.UpdateReader(new ReaderEntity(null, readerDetailsDTO.getReaderFname(),
                readerDetailsDTO.getReaderLname(), readerDetailsDTO.getReaderNic(), null, null, null,
                readerDetailsDTO.getReaderStatus()));

    }

    @Override
    public List<ReaderEntity> SelectReaders(String s) throws Exception {

        return readerDAOImpl.LoadSelectReaders(s);
    }

    @Override
    public boolean DeleteReader(ReaderInsertDetailsDTO detailsDTO) throws Exception {

        return readerDAOImpl
                .DeleteReader(new ReaderEntity(null, null, null, detailsDTO.getReaderNic(), null, null, null, 0));
    }

}
