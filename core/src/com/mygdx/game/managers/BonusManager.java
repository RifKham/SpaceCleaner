package com.mygdx.game.managers;


public class BonusManager {
    int speed = 0;
    int fireRate = 0;
    int shootSize = 0;
    int max = 10;
    boolean needHeal;

    public void upgrade(int ut){
        switch (ut) {
            case 0:
                if (speed < max){
                    speed += 1;
                    break;
                }
                needHeal = true;
                break;
            case 1:
                if (fireRate < max * 50) {
                    fireRate += 50;
                    break;
                }
                break;
            case 2:
                if (shootSize < max * 2){
                    shootSize += 2;
                    break;
                }
                needHeal = true;
                break;
        }
    }

    public int getSpeed(){
        return speed;
    }

    public int getFireRate(){
        return fireRate;
    }

    public int getShootSize(){
        return shootSize;
    }

    public boolean heal(){
        return needHeal;
    }

    public void notNeedHeal() {
        needHeal = !needHeal;
    }

    public void restart(){
        speed = 0;
        fireRate = 0;
        shootSize = 0;
    }
}
