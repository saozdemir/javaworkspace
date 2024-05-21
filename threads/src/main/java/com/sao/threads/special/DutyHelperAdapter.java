package com.sao.threads.special;

import com.sao.threads.special.data.DutyPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description:
 */
public class DutyHelperAdapter implements IDutyHelper, IDutyHelperAdapter{

    public void calculateDutyData() {
//        List<ThreadOperation> pool = new ArrayList<>();
//        for (int i=0;i<5;i++){
//            pool.add(new ThreadOperation());
//        }
//
//        for(Thread thread : pool){
//            thread.start();
//        }
    }

    public void exceptionDetected() {

    }

    public void resultReady(List<DutyPlan> result) {

    }
}
