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
                        </tr>
                    <xsl:for-each select="/albums/album">
                        <xsl:sort select="@id" order="ascending"/>
                        <tr>
                            <td> <xsl:value-of select="@id"/> </td>
                            <td> <xsl:value-of select="name"/> </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
