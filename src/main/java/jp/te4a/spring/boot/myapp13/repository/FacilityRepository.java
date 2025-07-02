package jp.te4a.spring.boot.myapp13.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.te4a.spring.boot.myapp13.bean.FacilityBean;

@Repository
public interface FacilityRepository extends JpaRepository<FacilityBean, Integer> {

    @Query("SELECT X FROM FacilityBean X ORDER BY X.name")
    List<FacilityBean> findAllOrderByName();

    /*
    private final ConcurrentMap<Integer, FacilityBean> facilityMap = new ConcurrentHashMap<>();
    private int FACILITY_ID = 1;

    public int getFacilityId() {
        return FACILITY_ID++;
    }

    public FacilityBean save(FacilityBean facilityBean) {
        return facilityMap.put(facilityBean.getId(), facilityBean);
    }

    public FacilityBean update(FacilityBean updateFacilityBean) {
        FacilityBean facilityBean = facilityMap.get(updateFacilityBean.getId());
        BeanUtils.copyProperties(updateFacilityBean, facilityBean);
        return facilityBean;
    }

    public void delete(Integer facilityId) {
        facilityMap.remove(facilityId);
    }

    public List<FacilityBean> findAll() {
        return new ArrayList<>(facilityMap.values());
    }

    public FacilityBean findOne(Integer id) {
        return facilityMap.get(id);
    }
    */
}
