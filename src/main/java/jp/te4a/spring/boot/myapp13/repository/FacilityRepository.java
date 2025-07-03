package jp.te4a.spring.boot.myapp13.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.te4a.spring.boot.myapp13.bean.FacilityBean;

@Repository
public interface FacilityRepository extends JpaRepository<FacilityBean,Integer>{

    @Query("SELECT X FROM FacilityBean X ORDER BY X.title")
    List<FacilityBean> findAllOrderByTitle();
    /*
    private final ConcurrentMap<Integer,BookBean> bookMap = new ConcurrentHashMap<>();
    private int BOOK_ID = 1;
    public int getBookId(){
        return BOOK_ID++;
    }

    public BookBean save(BookBean bookBean) {
        return bookMap.put(bookBean.getId(),bookBean);
    }

    public BookBean update(BookBean updateBookBean){
        BookBean bookBean = bookMap.get(updateBookBean.getId());
        BeanUtils.copyProperties(updateBookBean, bookBean);
        return bookBean;
    }

    public void delete(Integer bookId) {
        bookMap.remove(bookId);
    }

    public List<BookBean> findAll() {
        return new ArrayList<>(bookMap.values());
    }
    
    public BookBean findOne(Integer id) {
        return bookMap.get(id);
    }
        */
}
