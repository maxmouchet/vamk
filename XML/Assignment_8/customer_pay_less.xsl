<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Customer who pays the least for renting movies</h2>
                <ul>
                    <xsl:for-each select="//customers/customer[count(rented_movies/rented_movie)>0]">
                        <xsl:sort data-type="number"
                                  select="sum(//movies/movie[@id=rented_movies/rented_movie/@id]/price)"
                                  order="ascending"/>
                        <xsl:if test="position() = last()">
                            <strong>Name:</strong>
                            <xsl:value-of select="name"/>
                            <br/>
                            <strong>Id:</strong>
                            <xsl:value-of select="@id"/>
                            <br/>
                            <strong>Phone:</strong>
                            <xsl:value-of select="phone"/>
                            <br/>
                            <strong>Movies rented:</strong>
                            <ul>
                                <xsl:for-each select="rented_movies/rented_movie">
                                    <xsl:variable name="movieId" select="."/>
                                    <xsl:variable name="price" select="//movies/movie[@id=$movieId]/price"/>
                                    <xsl:variable name="duration" select="@duration"/>
                                    <li>
                                        <xsl:value-of select="//movies/movie[@id=$movieId]/nam"/>
                                        (Price to pay: <xsl:value-of select="$price"/>€ x
                                        <xsl:value-of
                                                select="$duration"/> = <xsl:value-of select="$price*$duration"/>€)
                                    </li>
                                </xsl:for-each>
                            </ul>
                        </xsl:if>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
