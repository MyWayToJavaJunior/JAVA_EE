package ru.sstu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sstu.model.db.Groups;
import ru.sstu.model.db.Students;
import ru.sstu.model.form.StudentForm;
import ru.sstu.service.AccpService;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * Created by Shvarts on 18.01.2017.
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private AccpService accpService;

    @RequestMapping("/students")
    @ResponseBody
    public String allStudents()
    {
        return accpService.getAllStudents().size() + " students";
    }

    @RequestMapping(value = "/students", params = "name")
    @ResponseBody
    public String allStudentsByName(@RequestParam("name") String name)
    {
        return accpService.getAllStudentsByName(name).size() + " students with name '" + name + "'";
    }

    @RequestMapping(value = "/students", params = "idGroup")
    @ResponseBody
    public String allStudentsByGroupId(@RequestParam("idGroup") int idGroup)
    {
        return accpService.getAllStudentsByGroup(idGroup).size() + " students from group with ID=" + idGroup;
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentForm(ModelMap modelMap)
    {
        modelMap.addAttribute("studentForm", new StudentForm());
        return "addStudentForm";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("studentForm") StudentForm studentForm, BindingResult result, ModelMap modelMap)
    {
        //
        if(result.hasErrors()) {
            modelMap.addAttribute("studentForm", studentForm);
            return "addStudentForm";
        }
        else
        {
            //СОЗДАТЬ СТУДЕНТА
            Students newStudent = new Students();
            newStudent.setName(studentForm.getName());
            newStudent.setSurname(studentForm.getSurname());

            SimpleDateFormat sdf = new SimpleDateFormat();

            Date d = new Date(System.currentTimeMillis());
            try {
                d = new Date(
                        sdf.parse(studentForm.getBirthdate()).getTime()
                );
            } catch (ParseException e) {
                //FIXME
            }
            finally {
                newStudent.setBirthdate(d);
            }

            //ГРУППА
            Groups g = accpService.getOneGroup(studentForm.getGroup());
            newStudent.setGroupsByIdGroup(g);


            accpService.saveStudent(newStudent);



            modelMap.addAttribute("newStudent", newStudent);
            return "addStudentResult";
        }
    }
}
