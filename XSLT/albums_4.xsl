<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : albums.xsl
    Created on : 11 Ноябрь 2015 г., 15:40
    Author     : user
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Albums</title>
            </head>
            <body>
                <h1>All albums</h1>
                <table border="1">
                    <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>year</td>
                            <td>Additional info</td>
                        </tr>
                    <xsl:for-each select="/albums/album">
                        <tr>
                            <td> <xsl:value-of select="@id"/> </td>
                            <td> <xsl:value-of select="name"/> </td>
                            <td> <xsl:value-of select="year"/> </td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="year &gt;= 2000">
                                        NEW!!!
                                    </xsl:when>
                                    <xsl:when test="year &lt; 2000 and year &gt;= 1990">
                                        Relatively old
                                    </xsl:when>
                                    <xsl:otherwise>
                                        Old
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
