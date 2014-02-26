<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>List of customers who have rented movies</h2>
                <ul>
                    <xsl:for-each select="//customers/customer">
                        <xsl:if test="rented_movies">
                            <li>
                                <strong>Name:</strong>
                                <xsl:value-of select="name"/>
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
                                            (Price to pay: <xsl:value-of select="$price"/>€ x
                                            <xsl:value-of
                                                    select="$duration"/> = <xsl:value-of select="$price*$duration"/>€)
                                        </li>
                                    </xsl:for-each>
                                </ul>
                            </li>
                            <br/>
                        </xsl:if>
                    </xsl:for-each>
                </ul>

                <h2>List of customers who have not rented movies</h2>
                <ul>
                    <xsl:for-each select="//customers/customer">
                        <xsl:if test="not(rented_movies)">
                            <li>
                                <strong>Name:</strong>
                                <xsl:value-of select="name"/>
                                <br/>
                                <strong>Phone number:</strong>
                                <xsl:value-of select="phone"/>
                                <br/>
                                <strong>Id:</strong>
                                <xsl:value-of select="@id"/>
                            </li>
                            <br/>
                        </xsl:if>
                    </xsl:for-each>
                </ul>

                <h2>List of rented movies</h2>
                <ul>
                    <xsl:for-each select="//movies/movie">
                        <xsl:if test="//customers/customer/rented_movies/rented_movie = @id">
                            <li>
                                <xsl:value-of select="nam"/>
                            </li>
                        </xsl:if>
                    </xsl:for-each>
                </ul>

                <h2>List of free movies</h2>
                <ul>
                    <xsl:for-each select="//movies/movie">
                        <xsl:if test="not(//customers/customer/rented_movies/rented_movie = @id)">
                            <li>
                                <xsl:value-of select="nam"/>
                            </li>
                        </xsl:if>
                    </xsl:for-each>
                </ul>

                <h2>List of thriller movies</h2>
                <ul>
                    <xsl:for-each select="//movies/movie[@type='Triller']">
                        <li>
                            <xsl:value-of select="nam"/>
                        </li>
                    </xsl:for-each>
                </ul>

                <h2>Average rent duration</h2>
                <ul>
                    <xsl:value-of
                            select="sum(//customers/customer/rented_movies/rented_movie/@duration) div count(//customers/customer/rented_movies/rented_movie[@duration])"/>
                </ul>

                <h4>Cheapest movie</h4>
                <ul>
                    <xsl:for-each select="//movies/movie">
                        <xsl:sort data-type="number" select="price" order="ascending"/>
                        <xsl:if test="position() = 1">
                            <xsl:value-of select="nam"/>: <xsl:value-of select="price"/>€
                        </xsl:if>
                    </xsl:for-each>
                </ul>

                <h4>Most expensive movie</h4>
                <ul>
                    <xsl:for-each select="//movies/movie">
                        <xsl:sort data-type="number" select="price" order="ascending"/>
                        <xsl:if test="position() = last()">
                            <xsl:value-of select="nam"/>: <xsl:value-of select="price"/>€
                        </xsl:if>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>