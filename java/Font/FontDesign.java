package Font;

/**
 * Created by system9 on 7/29/2017.
 */


        import android.content.Context;
        import android.graphics.Typeface;
        import android.util.AttributeSet;
        import android.widget.TextView;

public class FontDesign extends TextView {
    public static Typeface FONT_NAME;

    public FontDesign(Context context) {
        super(context);
        isInEditMode();
    }

    public FontDesign(Context context, AttributeSet attrs) {
        super(context, attrs);
        isInEditMode();
    }

    public FontDesign(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        isInEditMode();
    }

    public void setTypeface(Typeface tf, int style) {
        if (!isInEditMode()) {
            Typeface normalTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
            Typeface boldTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto.bold.ttf");
            if (style == 1) {
                super.setTypeface(boldTypeface);
            } else {
                super.setTypeface(normalTypeface);
            }
        }
    }
}
