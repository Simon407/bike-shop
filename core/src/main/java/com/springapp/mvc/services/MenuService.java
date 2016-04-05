package com.springapp.mvc.services;

import com.springapp.mvc.info.CategoryInfo;
import com.springapp.mvc.info.MenuInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Сервис для работы с навигацией
 */
@Service
public class MenuService {

    /**
     * Получаем основное меню сайта
     */
    public List<MenuInfo> getMainMenu() {
        List<MenuInfo> listMenu = new ArrayList<MenuInfo>();
        listMenu.add(new MenuInfo(1L, "BICYCLES", "/bicycles"));
        listMenu.add(new MenuInfo(2L, "PARTS", "/parts"));
        listMenu.add(new MenuInfo(3L, "ACCESSORIES", "/accessories"));
        listMenu.add(new MenuInfo(4L, "EXTRAS", "/extras"));
        return listMenu;
    }

    /**
     * Получаем категории для отображения в меню
     */
    public List<MenuInfo> getCategoryForMenu() {
        List<MenuInfo> listMenu = getMainMenu();

        List<CategoryInfo> by = new ArrayList<CategoryInfo>();
        by.add(new CategoryInfo(1L, 1L, "MOUNTAIN BIKES", "/bicycles/1", "/resources/images/c1.jpg", "Exclusive Mountain Bikes"));
        by.add(new CategoryInfo(1L, 2L, "SINGLE SPEED BIKES", "/bicycles/2", "/resources/images/c2.jpg", "Are you ready for the 27.5 Revolution ?"));
        by.add(new CategoryInfo(1L, 3L, "ROAD BIKES", "/bicycles", "/resources/images/c3.jpg", "Street Playground"));

        List<CategoryInfo> pa = new ArrayList<CategoryInfo>();
        pa.add(new CategoryInfo(2L, 1L, "CHAINS", "/parts"));
        pa.add(new CategoryInfo(2L, 2L, "TUBES", "/parts"));
        pa.add(new CategoryInfo(2L, 3L, "TIRES", "/parts"));
        pa.add(new CategoryInfo(2L, 4L, "DISC BREAKS", "/parts"));

        List<CategoryInfo> ac = new ArrayList<CategoryInfo>();
        ac.add(new CategoryInfo(3L, 1L, "LOCKS", "/accessories"));
        ac.add(new CategoryInfo(3L, 2L, "HELMETS", "/accessories"));
        ac.add(new CategoryInfo(3L, 3L, "ARM COVERS", "/accessories"));
        ac.add(new CategoryInfo(3L, 4L, "JERSEYS", "/accessories"));

        List<CategoryInfo> ex = new ArrayList<CategoryInfo>();
        ex.add(new CategoryInfo(4L, 1L, "CLASSIC BELL", "/extras"));
        ex.add(new CategoryInfo(4L, 2L, "BOTTLE CAGE", "/extras"));
        ex.add(new CategoryInfo(4L, 3L, "TRUCK GRIP", "/extras"));

        listMenu.get(0).setListCategory(by);
        listMenu.get(1).setListCategory(pa);
        listMenu.get(2).setListCategory(ac);
        listMenu.get(3).setListCategory(ex);

        return listMenu;
    }
}