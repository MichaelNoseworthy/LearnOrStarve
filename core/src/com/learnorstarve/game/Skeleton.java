package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

/**
 * Created by markapptist on 2018-10-12.
 */

public class Skeleton extends ActorBeta {

    Skeleton() {

      //  String[] walkAnim = new String[3];
       // String[] walkAnim = {"skeletons_0.png",
                             //   "skeletons_1.png",
                             //       "skeletons_2.png"};

     //   for(int i = 0; i <= 2; i++) {
     //       walkAnim[i] = "skeletons_" + i + ".png";
     //   }

     //   loadAnimationFromFiles(walkAnim, 0.1f, true);

        loadAnimationFromSheet("skeletons.png", 4, 9, 0.1f, true);

        MoveByAction moveByAction = new MoveByAction();
        moveByAction.setAmountX(100.0f);
        moveByAction.setDuration(10.0f);

      //  this.addAction(moveByAction);

        ScaleByAction scaleByAction = new ScaleByAction();
        scaleByAction.setAmount(4.0f);
        scaleByAction.setDuration(4.0f);

      //  this.addAction(scaleByAction);

        RotateByAction rotateByAction = new RotateByAction();
        rotateByAction.setAmount(180.0f);
        rotateByAction.setDuration(5.0f);

        SequenceAction sequenceAction = new SequenceAction(moveByAction, scaleByAction, rotateByAction);

        ParallelAction parallelAction = new ParallelAction(moveByAction,scaleByAction, rotateByAction);

        RepeatAction repeatAction = new RepeatAction();
        repeatAction.setAction(parallelAction);
        repeatAction.setCount(4);

     //   this.addAction(repeatAction);

    }

    @Override
    public void act(float dt) {
        super.act(dt);





    }
}
