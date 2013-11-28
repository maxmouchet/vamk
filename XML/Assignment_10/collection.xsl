<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body>
				<h2>All CDs</h2>
				<ul>
					<xsl:for-each select="//cds/cd">
						<li>
							<strong>Title:</strong>
							<xsl:value-of select="title" />
							<br />
							<strong>Artist:</strong>
							<xsl:value-of select="artist" />
							<br />
							<strong>Company ID:</strong>
							<xsl:value-of select="company_id" />
							<br />
							<strong>Price:</strong>
							<xsl:value-of select="price" />
							<br />
							<strong>Year:</strong>
							<xsl:value-of select="year" />
							<br />
						</li>
						<br />
					</xsl:for-each>
				</ul>

				<h2>All Companies</h2>
				<ul>
					<xsl:for-each select="//companies/company">
						<li>
							<strong>ID:</strong>
							<xsl:value-of select="id" />
							<br />
							<strong>Name:</strong>
							<xsl:value-of select="name" />
							<br />
						</li>
						<br />
					</xsl:for-each>
				</ul>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>
