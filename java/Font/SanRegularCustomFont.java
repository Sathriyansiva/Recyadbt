package Font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by system9 on 7/22/2017.
 */

public class SanRegularCustomFont extends TextView
{
    public static Typeface FONT_NAME;

    public SanRegularCustomFont(Context paramContext)
    {
        super(paramContext);
        isInEditMode();
    }

    public SanRegularCustomFont(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        isInEditMode();
    }

    public SanRegularCustomFont(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        isInEditMode();
    }

    public void setTypeface(Typeface paramTypeface, int paramInt)
    {
        if (!isInEditMode())
        {
            paramTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/SourceSansPro-Regular.otf");
            Typeface localTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/SourceSansPro-Regular.otf");
            if (paramInt == 1) {
                super.setTypeface(localTypeface);
            }
        }
        else
        {
            return;
        }
        super.setTypeface(paramTypeface);
    }
}


/* Location:              F:\Android\decompiler\dex2jar-2.0\classes-dex2jar.jar!\com\brainmagic\leatherexport\font\SanRegularCustomFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */