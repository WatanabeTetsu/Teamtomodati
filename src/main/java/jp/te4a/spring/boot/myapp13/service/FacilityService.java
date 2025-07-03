package jp.te4a.spring.boot.myapp13.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp13.bean.FacilityBean;
import jp.te4a.spring.boot.myapp13.form.FacilityForm;
import jp.te4a.spring.boot.myapp13.repository.FacilityRepository;

@Service
public class FacilityService {
    @Autowired
    FacilityRepository facilityRepository;
    public FacilityForm create(FacilityForm facilityForm) {
        //bookForm.setId(bookRepository.getBookId());
        FacilityBean facilityBean = new FacilityBean();
        BeanUtils.copyProperties(facilityForm, facilityBean);
        facilityRepository.save(facilityBean);
        return facilityForm;
    }

    public FacilityForm save(FacilityForm facilityForm) {
        FacilityBean facilityBean = new FacilityBean();
        BeanUtils.copyProperties(facilityForm, facilityBean);
        facilityRepository.save(facilityBean);
        return facilityForm;
    }
      

    public FacilityForm update(FacilityForm facilityForm) {
        FacilityBean facilityBean = new FacilityBean();
        BeanUtils.copyProperties(facilityForm, facilityBean);
        facilityRepository.save(facilityBean);
        return facilityForm;
    }

    public void delete(Integer id) { 
        facilityRepository.deleteById(id); 
    }
    
    public List<FacilityForm> findAll() {
        List<FacilityBean> beanList = facilityRepository.findAll();
        List<FacilityForm> formList = new ArrayList<FacilityForm>();
        for(FacilityBean facilityBean: beanList) {
            FacilityForm facilityForm = new FacilityForm();
            BeanUtils.copyProperties(facilityBean, facilityForm);
            formList.add(facilityForm);
        }
        return formList;
    }
    public FacilityForm findOne(Integer id) {
        //BookBean bookBean = bookRepository.findOne(id);
        Optional<FacilityBean> opt = facilityRepository.findById(id);
        FacilityBean facility = opt.get();
        FacilityForm facilityForm = new FacilityForm();
        BeanUtils.copyProperties(facility, facilityForm);
        return facilityForm;
    }

}
