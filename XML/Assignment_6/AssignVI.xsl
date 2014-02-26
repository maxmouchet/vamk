<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/collection">
<html>
<body>

  <!-- Question 1 -->
  <h2>The list of CDs, whose name start with S</h2>
  <ul>
  <xsl:for-each select="//titles/title">
    <xsl:variable name="titleVariable" select="."/>
    <xsl:if test="starts-with($titleVariable, 'S')">
      <li><xsl:value-of select="$titleVariable"/></li>
    </xsl:if>
  </xsl:for-each>
  </ul>

  <!-- Question 2 -->
  <h2>The list of CDs, which belong to Cuba</h2>
  <ul>
  <xsl:for-each select="cds/cd[@country='Cuba']/*/title">
    <li><xsl:value-of select="."/></li>
  </xsl:for-each>
  </ul>

  <!-- Question 3 -->
  <h2>The full information of companies with ids: C100 and C600</h2>
  <ul>
  <xsl:for-each select="Companies/company">
    <xsl:if test=".//id = 'C100' or .//id = 'C600'">
      <li><xsl:value-of select=".//name"/>, <xsl:value-of select=".//address"/></li>
    </xsl:if>
  </xsl:for-each>
  </ul>

  <!-- Question 4 -->
  <h2>The full information of the cheapest and most expensive CD</h2>
  <xsl:for-each select="cds/cd">
    <xsl:sort select="price" data-type="number" order="ascending" />
    <xsl:if test="position() = 1">
      Cheapest CD: 
      <table border="1">
        <tr bgcolor="#9bcd80">
          <th align="left">Country</th>
          <th align="left">Artist</th>
          <th align="left">Titles</th>
          <th align="left">Price</th>
          <th align="left">Companies</th>
        </tr> 
        <tr>
          <td><xsl:value-of select="@country" /></td>
          <td><xsl:value-of select="artist" /></td>
          <td>
            <table>
              <tr>
                <xsl:for-each select=".//title">
                  <tr><td><xsl:value-of select="." /></td></tr>
                </xsl:for-each>
              </tr>
            </table>
          </td>
          <td><xsl:value-of select="price" /></td>
          <td>
            <table>
              <xsl:for-each select="company_ids/company_id">
                <xsl:variable name="my_company_id" select="."/>
                <tr><td>
                  <xsl:value-of select="//company[id=$my_company_id]/name"/>, 
                  <xsl:value-of select="//company[id=$my_company_id]/address"/>
                </td></tr>
              </xsl:for-each>
            </table>
          </td>
        </tr>
      </table>
    </xsl:if>
    <xsl:if test="position() = last()">
      <br />Most expensive CD: 
      <table border="1">
        <tr bgcolor="#9bcd80">
          <th align="left">Country</th>
          <th align="left">Artist</th>
          <th align="left">Titles</th>
          <th align="left">Price</th>
          <th align="left">Companies</th>
        </tr> 
        <tr>
          <td><xsl:value-of select="@country" /></td>
          <td><xsl:value-of select="artist" /></td>
          <td>
            <table>
              <tr>
                <xsl:for-each select=".//title">
                  <tr><td><xsl:value-of select="." /></td></tr>
                </xsl:for-each>
              </tr>
            </table>
          </td>
          <td><xsl:value-of select="price" /></td>
          <td>
            <table>
              <xsl:for-each select="company_ids/company_id">
                <xsl:variable name="my_company_id" select="."/>
                <tr><td>
                  <xsl:value-of select="//company[id=$my_company_id]/name"/>, 
                  <xsl:value-of select="//company[id=$my_company_id]/address"/>
                </td></tr>
              </xsl:for-each>
            </table>
          </td>
        </tr>
      </table>
    </xsl:if>
  </xsl:for-each>

  <!-- Question 5 -->
  <h2>The name and address of companies, which do not have any CD in the list</h2>
  <table border="1">
    <tr bgcolor="#9bcd80">
      <th align="left">Name</th>
      <th align="left">Address</th>
    </tr> 
    <xsl:for-each select="//company">
      <xsl:variable name="comp_id" select="id"/>
      <xsl:variable name="company_position" select="position()"/>
      <xsl:variable name="relevant_cd" select="//cd/company_ids[company_id=$comp_id]"/>
        
        <xsl:if test="string-length(normalize-space($relevant_cd))=0">
          <tr style="background-color=yellow">
            <td><xsl:value-of select="//company[$company_position]/name"/> </td>
            <td><xsl:value-of select="//company[$company_position]/address"/> </td>
          </tr>
        </xsl:if>
    </xsl:for-each>
  </table>

</body>
</html>
</xsl:template>
</xsl:stylesheet>