package com.sao.threads.special;

import com.sao.threads.special.data.DutyPlan;

import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description:
 */
public interface IDutyHelperAdapter extends IMultiThreadExceptionHandler{
    void resultReady(List<DutyPlan> result);
}
