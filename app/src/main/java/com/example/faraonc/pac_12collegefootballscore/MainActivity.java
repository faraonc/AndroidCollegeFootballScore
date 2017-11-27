package com.example.faraonc.pac_12collegefootballscore;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

/**
 * The main ctivity handler for the app.
 *
 * @author Conard James Faraon
 * @version 11272017-00
 */
public class MainActivity extends AppCompatActivity {

    private int scoreA = 0;
    private int scoreB = 0;

    /* CONSTANTS */
    private final static int UW_COLOR = Color.parseColor("#4b2e83");
    private final static int WSU_COLOR = Color.parseColor("#981e32");
    private final static int SIX = 6;
    private final static int THREE = 3;
    private final static int TWO = 2;
    private final static int ONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     *
     * @param score the score of team A in int.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 6 points for a touchdown for Team A.
     * Disables adding scores after PAT or 2-point conversion.
     *
     * @param view The view that triggers the event handling.
     */
    public void addSixForTeamA(View view) {
        if ((this.scoreA + SIX) < Integer.MAX_VALUE) {
            disableAddingScoreForTeamA();
            disableScoreButtonsForTeamB();
            displayForTeamA(this.scoreA = this.scoreA + SIX);
        }
    }

    /**
     * Adds 3 points for a field goal for Team A.
     *
     * @param view The view that triggers the event handling.
     */
    public void addThreeForTeamA(View view) {
        if ((this.scoreA + THREE) < Integer.MAX_VALUE) {
            displayForTeamA(this.scoreA = this.scoreA + THREE);
        }
    }

    /**
     * Adds 2 points for a safety or a 2-point conversion for Team A.
     * Enables adding score buttons.
     *
     * @param view The view that triggers the event handling.
     */
    public void addTwoForTeamA(View view) {
        if ((this.scoreA + TWO) < Integer.MAX_VALUE) {
            enableAddingScoreForTeamA();
            enableAddingScoreForTeamB();
            displayForTeamA(this.scoreA = this.scoreA + TWO);
        }
    }

    /**
     * Adds a point for a PAT for Team A.
     * Enables adding score buttons.
     *
     * @param view The view that triggers the event handling.
     */
    public void addOneForTeamA(View view) {
        if ((this.scoreA + ONE) < Integer.MAX_VALUE) {
            enableAddingScoreForTeamA();
            displayForTeamA(this.scoreA = this.scoreA + ONE);
        }
        enableAddingScoreForTeamA();
        enableAddingScoreForTeamB();
    }

    /**
     * Enables adding score buttons after a failed PAT or 2pt-conversion for Team A.
     *
     * @param view The view that triggers the event handling.
     */
    public void failedPatForTeamA(View view) {
        enableAddingScoreForTeamA();
        enableAddingScoreForTeamB();
    }

    /**
     * Disables adding scores after a touchdown for Team A.
     */
    private void disableAddingScoreForTeamA() {
        //non PAT or 2pt-conversion buttons
        Button b = (Button) findViewById(R.id.td_button_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.fg_button_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.safety_button_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);

        //buttons for PAT and 2pt-conversion
        b = (Button) findViewById(R.id.pat_good_A);
        b.setEnabled(true);
        b.setBackgroundColor(WSU_COLOR);
        b = (Button) findViewById(R.id.pat_bad_A);
        b.setEnabled(true);
        b.setBackgroundColor(WSU_COLOR);
        b = (Button) findViewById(R.id.conv_A);
        b.setEnabled(true);
        b.setBackgroundColor(WSU_COLOR);
    }

    /**
     * Enables scoring after a PAT or a 2-pt conversion for Team A.
     */
    private void enableAddingScoreForTeamA() {
        //non PAT or 2pt-conversion buttons
        Button b = (Button) findViewById(R.id.td_button_A);
        b.setEnabled(true);
        b.setBackgroundColor(WSU_COLOR);
        b = (Button) findViewById(R.id.fg_button_A);
        b.setEnabled(true);
        b.setBackgroundColor(WSU_COLOR);
        b = (Button) findViewById(R.id.safety_button_A);
        b.setEnabled(true);
        b.setBackgroundColor(WSU_COLOR);

        //buttons for PAT and 2pt-conversion
        b = (Button) findViewById(R.id.pat_good_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.pat_bad_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.conv_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
    }

    /**
     * Disables all buttons for team A.
     */
    private void disableScoreButtonsForTeamA() {
        Button b = (Button) findViewById(R.id.td_button_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.fg_button_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.safety_button_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.pat_good_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.pat_bad_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.conv_A);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);

    }

    /**
     * Displays the given score for Team B.
     *
     * @param score the score of team B in int.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 6 points for a touchdown for Team B.
     * Disables adding scores after PAT or 2-point conversion.
     *
     * @param view The view that triggers the event handling.
     */
    public void addSixForTeamB(View view) {
        if ((this.scoreB + SIX) < Integer.MAX_VALUE) {
            disableAddingScoreForTeamB();
            disableScoreButtonsForTeamA();
            displayForTeamB(this.scoreB = this.scoreB + SIX);
        }
    }

    /**
     * Adds 3 points for a field goal for Team B.
     *
     * @param view The view that triggers the event handling.
     */
    public void addThreeForTeamB(View view) {
        if ((this.scoreB + THREE) < Integer.MAX_VALUE) {
            displayForTeamB(this.scoreB = this.scoreB + THREE);
        }
    }

    /**
     * Adds 2 points for a safety or a 2-point conversion for Team B.
     * Enables adding score buttons.
     *
     * @param view The view that triggers the event handling.
     */
    public void addTwoForTeamB(View view) {
        if ((this.scoreB + TWO) < Integer.MAX_VALUE) {
            enableAddingScoreForTeamA();
            enableAddingScoreForTeamB();
            displayForTeamB(this.scoreB = this.scoreB + TWO);
        }
    }

    /**
     * Adds a point for a PAT for Team B.
     * Enables adding score buttons.
     *
     * @param view The view that triggers the event handling.
     */
    public void addOneForTeamB(View view) {
        if ((this.scoreB + ONE) < Integer.MAX_VALUE) {
            displayForTeamB(this.scoreB = this.scoreB + ONE);
        }
        enableAddingScoreForTeamB();
        enableAddingScoreForTeamA();
    }

    /**
     * Enables adding score buttons after a failed PAT or 2pt-conversion for Team B.
     *
     * @param view The view that triggers the event handling.
     */
    public void failedPatForTeamB(View view) {
        enableAddingScoreForTeamB();
        enableAddingScoreForTeamA();
    }

    /**
     * Disables adding scores after a touchdown for Team B.
     */
    private void disableAddingScoreForTeamB() {
        //non PAT or 2pt-conversion buttons
        Button b = (Button) findViewById(R.id.td_button_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.fg_button_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.safety_button_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);

        //buttons for PAT and 2pt-conversion
        b = (Button) findViewById(R.id.pat_good_B);
        b.setEnabled(true);
        b.setBackgroundColor(UW_COLOR);
        b = (Button) findViewById(R.id.pat_bad_B);
        b.setEnabled(true);
        b.setBackgroundColor(UW_COLOR);
        b = (Button) findViewById(R.id.conv_B);
        b.setEnabled(true);
        b.setBackgroundColor(UW_COLOR);
    }

    /**
     * Enables scoring after a PAT or a 2-pt conversion for Team B.
     */
    private void enableAddingScoreForTeamB() {
        //non PAT or 2pt-conversion buttons
        Button b = (Button) findViewById(R.id.td_button_B);
        b.setEnabled(true);
        b.setBackgroundColor(UW_COLOR);
        b = (Button) findViewById(R.id.fg_button_B);
        b.setEnabled(true);
        b.setBackgroundColor(UW_COLOR);
        b = (Button) findViewById(R.id.safety_button_B);
        b.setEnabled(true);
        b.setBackgroundColor(UW_COLOR);

        //buttons for PAT and 2pt-conversion
        b = (Button) findViewById(R.id.pat_good_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.pat_bad_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.conv_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
    }

    /**
     * Disables all buttons for team B for Team B.
     */
    private void disableScoreButtonsForTeamB() {
        Button b = (Button) findViewById(R.id.td_button_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.fg_button_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.safety_button_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.pat_good_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.pat_bad_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);
        b = (Button) findViewById(R.id.conv_B);
        b.setEnabled(false);
        b.setBackgroundColor(Color.DKGRAY);

    }

    /**
     * Resets the state of the app.
     *
     * @param view The view that triggers the event handling.
     */
    public void reset(View view) {
        this.scoreA = this.scoreB = 0;
        enableAddingScoreForTeamA();
        enableAddingScoreForTeamB();
        displayForTeamA(this.scoreA);
        displayForTeamB(this.scoreB);

    }
}
