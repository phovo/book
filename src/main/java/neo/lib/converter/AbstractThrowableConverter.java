package neo.lib.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Throwable Converter
 *
 * @param <FROM>
 * @param <TO>
 * @param <EXCEPTION>
 */
public abstract class AbstractThrowableConverter <FROM, TO, EXCEPTION extends Exception>
    implements IConverter<FROM, TO, EXCEPTION>
{
    /**
     * @see pattern.converter.api.IConverter#convert(java.lang.Object)
     */
    @Override
    public abstract TO convert(FROM from) throws EXCEPTION;

    /**
     * @see pattern.converter.api.IConverter#convert(java.util.List)
     */
    @Override
    public List<TO> convert(List<FROM> fromList) throws EXCEPTION
    {
        List<TO> toList = null;
        if (fromList != null)
        {
            toList = new ArrayList<TO>();
            for (FROM from : fromList)
            {
                toList.add(convert(from));
            }
        }

        return toList;
    }
}
