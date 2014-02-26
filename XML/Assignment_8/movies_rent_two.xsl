<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Movies rented by at least two customers</h2>
                <ul>
                    <xsl:for-each select="//movies/movie">
                        <xsl:variable name="movieId" select="@id"/>
                        <xsl:if test="count(//customers/customer/rented_movies[rented_movie=$movieId]) > 1">
                            <li>
                                <strong>Name:</strong>
                                <xsl:value-of select="nam"/>
                                <br/>
                                <strong>Id:</strong>
                                <xsl:value-of select="@id"/>
                                <br/>
                                <strong>Type:</strong>
                                <xsl:value-of select="@type"/>
                                <br/>
                                <strong>Price:</strong>
                                <xsl:value-of select="price"/>
                                <br/>
                                <strong>Release year:</strong>
                                <xsl:value-of select="release_year"/>
                                <br/>
                                <strong>Number of times rented:</strong>
                                <xsl:value-of
                                        select="count(//customers/customer/rented_movies[rented_movie=$movieId])"/>
                                <br/>
                            </li>
                            <br/>
                        </xsl:if>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>