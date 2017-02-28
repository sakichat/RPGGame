package ui.view;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class ViewFlow extends View {

    /**
     * This is a constructor
     */
    public ViewFlow() {
        this.setLayout(null);
        this.setSize(1000, 600);
        contentViews = new ArrayList<View>();
    }

    /**
     * This is to declare a List for scene classes
     */
    private List<View> contentViews;

    /**
     * This method is for switching views
     * @param view
     */
    public void push(View view) {
        if (contentViews.size() > 0) {
        }

        contentViews.add(view);
        view.setViewFlow(this);
        view.setSize(this.getSize());
        this.add(view);
        view.viewDidDisplay();

    }

    public void pop() {
        if (contentViews.size() > 0) {
            View view = contentViews.get(contentViews.size() - 1);
            this.remove(view);
            contentViews.remove(view);
            contentViews.add(contentViews.get(contentViews.size() - 1));
        }

        if (contentViews.size() > 0) {
            View view = contentViews.get(contentViews.size() - 1);
            view.viewDidDisplay();
        }

    }
}
