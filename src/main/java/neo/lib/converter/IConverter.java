package neo.lib.converter;

import java.util.List;

/**
 * interface Converter
 *
 * @param <FROM>
 * @param <TO>
 * @param <EXCEPTION>
 */
public interface IConverter<FROM, TO, EXCEPTION extends Exception>
{
    /**
     * convert FROM to TO.
     *
     * @param from
     * @return TO
     * @throws EXCEPTION
     */
    TO convert(FROM from) throws EXCEPTION;

    /**
     * list convert from FROM to TO
     *
     * @param from
     * @return TO
     * @throws EXCEPTION
     */
    List<TO> convert(List<FROM> from) throws EXCEPTION;
}
