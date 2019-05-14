package com.example.diploma;

import android.net.Uri;

public class AllCategories {

        private String name;
        private String info;
        private String img;
        public String getName(){
            return name;
        }
        public String getInfo(){ return info; }
        public String getImg() {return img; }
        public void setName(String name){
            this.name = name;
        }
        public void setInfo(String info){
            this.info = info;
        }
        public void setImg (String img){this.img = img; }
        public String toString(){
            return  "Category: " + name + " - " + info;
        }
}
