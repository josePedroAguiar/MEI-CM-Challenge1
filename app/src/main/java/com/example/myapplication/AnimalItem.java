package com.example.myapplication;

public class AnimalItem {
        private int imageResource;
        private String text;

        public AnimalItem(int imageResource, String text) {
            this.imageResource = imageResource;
            this.text = text;
        }

        public int getImageResource() {
            return imageResource;
        }

        public String getText() {
            return text;
        }


}
