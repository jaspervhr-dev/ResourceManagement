package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Service.ProjectColumnService;
import com.itlize.ResourceManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Siteng Fan
 * @date 10/4/21 6:39 PM
 */
@RestController
@RequestMapping("/formula")
public class FormulaController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectColumnService projectColumnService;

    @RequestMapping("/addFormula")
    public ResponseEntity addFormula(@RequestParam String formula,
                                     @RequestParam Integer projectId,
                                     @RequestParam String columnName){
        Project project = projectService.findById(projectId);
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setColumnName(columnName);
        projectColumn.setFormulaText(formula);
        projectColumnService.addOne(projectColumn);
        return new ResponseEntity(HttpStatus.OK);
    }
}
