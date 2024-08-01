package libraryManagementSystem.dao.interfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.bookCategoriesEntitiy;
import libraryManagementSystem.dao.entity.genderEntity;

public interface loadItemsInterfaces {

    public List<bookCategoriesEntitiy> getAllBookCategories() throws Exception;

    public List<genderEntity> genderLoading() throws Exception;

    

}
