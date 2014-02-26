<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Customers who have rented at least three movies</h2>
                <ul>
                    <xsl:for-each select="//customers/customer">
                        <xsl:if test="count(rented_movies/rented_movie)>2">
                            <li>
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
                                        <xsl:variable name="duration">
                                            <xsl:choose>
                                                <xsl:when test="@duration">
                                                    <xsl:value-of select="@duration"/>
                                                </xsl:when>
                                                <xsl:otherwise>1</xsl:otherwise>
                                            </xsl:choose>
                                        </xsl:variable>
                                        <li>
                                            <xsl:value-of select="//movies/movie[@id=$movieId]/nam"/>
                                        </li>
                                    </xsl:for-each>
                                </ul>
                            </li>
                            <br/>
                        </xsl:if>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>