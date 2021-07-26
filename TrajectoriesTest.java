package com.example.meepmeeptrajectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;

public class TrajectoriesTest {
    public static void main(String[] args) {
        // TODO: If you experience poor performance, enable this flag
        System.setProperty("sun.java2d.opengl", "true");

        MeepMeep mm = new MeepMeep(800)
                .setBackground(MeepMeep.Background.FIELD_ULTIMATE_GOAL_DARK)
                .setTheme(new ColorSchemeRedDark())
                .setBackgroundAlpha(1f)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(0, 36, 180))
                                //triunghi
                                .lineToLinearHeading(new Pose2d(-36,-36, 0))
                                .lineToLinearHeading(new Pose2d(36,-36, Math.toRadians(120)))
                                .lineToLinearHeading(new Pose2d(0,36, Math.toRadians(180)))

                                //cerc
                                .splineTo(new Vector2d(-36,0), Math.toRadians(270))
                                .splineTo(new Vector2d(0,-36), 0)
                                .splineTo(new Vector2d(36,0), Math.toRadians(90))
                                .splineTo(new Vector2d(0,36), Math.toRadians(180))
                                .build()
                )
                .start();
    }
}