package libraryManagementSystem.service;

import java.util.List;

import libraryManagementSystem.dao.loadItemsDAOImpl;
import libraryManagementSystem.dao.entity.bookCategoriesEntitiy;
import libraryManagementSystem.dao.entity.genderEntity;
import libraryManagementSystem.service.serviceInterfaces.ItemAddServiceInterface;

public class ItemAddService implements ItemAddServiceInterface {

    private loadItemsDAOImpl loadItemsDAOImpl;

    public ItemAddService() {

        loadItemsDAOImpl = new loadItemsDAOImpl();

    }

    @Override
    public List<bookCategoriesEntitiy> getAllBookCategories() throws Exception {

        return loadItemsDAOImpl.getAllBookCategories();

    }

    @Override
    public List<genderEntity> getAllGenders() throws Exception {

        return loadItemsDAOImpl.genderLoading();
        
    }

}
