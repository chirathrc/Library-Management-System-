package libraryManagementSystem.dao.interfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.ReaderEntity;

public interface ReaderDAOInterface {

    public Boolean InsertReader(ReaderEntity readerEntity) throws Exception;

    public List<ReaderEntity> LoadAllReaders() throws Exception;

    public boolean UpdateReader(ReaderEntity readerEntity) throws Exception;

    public List<ReaderEntity> LoadSelectReaders(String s) throws Exception;

    public Boolean DeleteReader(ReaderEntity entity) throws Exception;

}
