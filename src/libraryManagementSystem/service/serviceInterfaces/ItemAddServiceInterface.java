package libraryManagementSystem.service.serviceInterfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.bookCategoriesEntitiy;
import libraryManagementSystem.dao.entity.genderEntity;

public interface ItemAddServiceInterface {

    public List<bookCategoriesEntitiy> getAllBookCategories() throws Exception;

    public List<genderEntity> getAllGenders() throws Exception;

}
